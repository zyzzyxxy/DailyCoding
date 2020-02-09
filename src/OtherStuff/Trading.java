package OtherStuff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Trading {
    double[] dataGold;
    int counter;
    int waitingRounds = 100;
    double oldValuesStack;
    double meanValue;
    double minValue;
    double maxValue;
    double money;
    double buyingFee = 0;
    double cautionlevel = 0.1; //How eager we are going to be on market
    double stockValue;
    double earningsPerStock; //
    List<Holding> holdings;

    public Trading() throws IOException, InterruptedException {
        money = 10000;
        dataGold = readDataFromCsv();
        holdings = new ArrayList<>();
        earningsPerStock = 1.7;
        startTradingSimulation();

    }

    private void startTradingSimulation() throws InterruptedException {
        double currentGoldValue=0;

        while(counter< dataGold.length){
            currentGoldValue = dataGold[counter];
            calcNewMean(currentGoldValue);
            if(counter>waitingRounds) {
                checkIfBuy(currentGoldValue);
                checkIfSell(currentGoldValue);
            }
            counter ++;
            System.out.println("Money after round " + counter +": "+ money + "        current goldPrice: " + currentGoldValue);
            Thread.sleep(1);
        }
        sellAll(holdings, currentGoldValue);
        System.out.println("Money after round " + counter +": "+ money + "        current goldPrice: " + currentGoldValue);

    }

    private void sellAll(List<Holding> holdings, double currentGoldValue) {
        for (Holding h:holdings) {
                sell(h, currentGoldValue);
        }
    }

    private void calcNewMean(double currentGoldValue) {
        oldValuesStack+=currentGoldValue;
        meanValue = oldValuesStack / counter+1;// +1 to avoid division by zero
    }

    private void checkIfBuy(double currentGoldValue) {
       double priceAgainstMeanRatio = meanValue - currentGoldValue;
       if(meanValue>0){ //buy stock according to diff to mean
            double percentOfDiff = 1 - (priceAgainstMeanRatio/meanValue );
            double moneyToSpend = money*percentOfDiff*cautionlevel;
            buy(currentGoldValue, moneyToSpend);

       }

    }

    private void checkIfSell(double currentGoldValue) {
        ArrayList<Holding> soldHoldings = new ArrayList<>();
        for (Holding h:holdings) {
            if(h.buyingPrice>currentGoldValue*earningsPerStock){
                sell(h, currentGoldValue);
                soldHoldings.add(h);
            }
        }
        for (Holding h:soldHoldings){
            holdings.remove(h);
        }
    }

    class Holding{
        int shares;
        double buyingPrice;

        public Holding(int shares, double buyingPrice) {
            this.shares = shares;
            this.buyingPrice = buyingPrice;
        }
    }

    private double[] readDataFromCsv() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("/Users/johanericsson/git/DailyCoding/src/OtherStuff/GOLD.csv"));
        String row;
        ArrayList<Double> allData = new ArrayList<>();
        while ((row =csvReader.readLine()) != null){
            allData.add(Double.parseDouble(row.split(",")[1]));
        }
        double[] result = new double[allData.size()];
        for (int i = 0; i<allData.size(); i++) {
            result[i] = allData.get(i);
        }
        return result;
    }

    public void buy(double currentGoldValue, double moneyToSpend){
        int shares = 0;
        while(moneyToSpend>currentGoldValue){
            shares++;
            moneyToSpend-=currentGoldValue;
        }
        holdings.add(new Holding(shares, currentGoldValue));
        money-=shares*currentGoldValue;
    }
    public void sell(Holding h, double currentGoldValue){
        money += h.shares*currentGoldValue;
    }
}
