enum LineType {SOLID, DOTTED, DASHED, DOUBLE}

public static String drawLine(LineType lineType) {
    String res ="The line is " +lineType.toString().toLowerCase() + " type";
	return res;
}
