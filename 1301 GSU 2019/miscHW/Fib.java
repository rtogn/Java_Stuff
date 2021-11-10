class Fib{
    //Functions and not really correct but I need to move on
    public static void main(String[] args){
        int stores = 1;
        int previous = 1;
        int number = 0;
        System.out.print(stores + " ");
        System.out.print(previous + " ");
        for (int i = 1; i<=10; i++){
            number = stores + previous;
            previous = stores;
            stores = number;
            System.out.print(number + " ");
            
            
        }
    }
}

output:

1 1 2 3 5 8 13 21 34 55 89 144 