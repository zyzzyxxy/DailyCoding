
public class teslaCounting {
        double dollar_value = 8.73;
        int shares = 0;
        int floating_shares = 0;
        int start_selling = 0;
        int selling_spread = 0;
        int end_value = start_selling + selling_spread*floating_shares;
        double value_selling;
        double value_not_selling;
        double cash_if_sell;

        int million = 1000000;

        public teslaCounting(){
            int nbr = 5*million*999;
            while(nbr %10 == 0){
                nbr=nbr/10;
            }
            System.out.println(nbr);
            System.out.println("end_value: " + end_value);
            value_selling = end_value*(shares-floating_shares)*dollar_value;
            value_not_selling = end_value*(shares)*dollar_value;

            //Not elegant (n-1)*n/n kinda thing better
            for (int i = 0; i <floating_shares ; i++) {
                cash_if_sell += start_selling;
                start_selling +=selling_spread;
            }
            cash_if_sell*=dollar_value;

            System.out.println("Value of stocks: " + value_selling + " sek, value of money: " + cash_if_sell/million + " million" );
            System.out.println("Total value If sell: " + (value_selling+cash_if_sell)/million);
            System.out.println("Value of stocks no sell: " + value_not_selling/million + " sek" );

        }

}
