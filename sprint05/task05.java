class InsufficientAmountException extends Exception{
    
    private double amount;
    
    public InsufficientAmountException(double amount){
        this.amount = amount;
    }
    
    public String getMessage(){
        return "Sorry, but you are short $" + amount;
    }
    
    public double getAmount(){
        return amount;
    }
}
