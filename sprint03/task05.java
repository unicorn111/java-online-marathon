enum ClientType {
    NEW(1),
    SILVER(12),
    GOLD(30),
    PLATINUM(60);
    
    private int months;
    private double discount = 1.0D;
    ClientType(int months) {
       this.months = months;
    }
    public double discount(){
        switch (months) {
            case 1:
                return discount;
            case 12:
                discount = (100 - months * 0.25)/ (double)100;
                return discount;
            case 30:
                discount = (100 - months * 0.3)/ (double)100;
                return discount;
            case 60:
                discount = (100 - months * 0.35)/ (double)100;
                return discount;
       }
		return discount;
    }
}
