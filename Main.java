class Main{
    public static void main(String[] args){
        Date randomDate = new Date();
        System.out.println(randomDate.getDate());
        System.out.println(randomDate.getAlphabeticalDate());
        
        Date setDate = new Date();
        setDate.setDay(12);
        setDate.setMonth(10);
        setDate.setYear(1900);
        //System.out.println(setDate.getDate());
    }
}