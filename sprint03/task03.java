public static void addAtoB(int a, int b) {
    Strategy strategy = new Strategy() {
            public double doOperation(int a, int b) {
                return a+b;
            }
        };
    execute(a, b, strategy);
}

public static void subtractBfromA(int a, int b) {
    Strategy strategy = new Strategy() {
            public double doOperation(int a, int b) {
                return a-b;
            }
        };
    execute(a, b, strategy);
}

public static void multiplyAbyB(int a, int b) {
    Strategy strategy = new Strategy() {
            public double doOperation(int a, int b) {
                return a*b;
            }
        };
    execute(a, b, strategy);
}

public static void divideAbyB(int a, int b) {
    Strategy strategy = new Strategy() {
            public double doOperation(int a, int b) {
                return a/(double)b;
            }
        };
    execute(a, b, strategy);
}
