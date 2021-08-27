public static Plant tryCreatePlant(String type, String color, String name) throws TypeException, ColorException{
    try{
        return new Plant(type, color, name);
    }catch(TypeException e){
        try{
            return new Plant("ORDINARY", color, name);
        }catch(ColorException ex){
            return new Plant("ORDINARY", "RED", name);
        }
    }
    catch(ColorException e){
        try{
            return new Plant(type, "RED", name);
        }catch(TypeException ex){
            return new Plant("ORDINARY", "RED", name);
        }
    }
}
