package no.hvl.dat250;

import io.javalin.Javalin;

public class App {

    private static final String WEBPAGE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Convert units</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1>Unit converter</h1>\n" +
            "<form action=\"/convert\" method=\"post\">\n" +
            "    <fieldset>\n" +
            "    <label for=\"val\">Value:</label>" +
            "    <input id=\"val\" type=\"text\" name=\"value\"><br />\n" +
            "    <label for=\"source-unit\">From unit:</label>\n" +
            "    <select name=\"sunit\" id=\"source-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <label for=\"target-unit\">To unit:</label>\n" +
            "    <select name=\"tunit\" id=\"target-unit\">\n" +
            "        <option value=\"in\">Inches</option>\n" +
            "        <option value=\"ft\">Feet</option>\n" +
            "        <option value=\"mi\">Miles</option>\n" +
            "        <option value=\"m\">Metres</option>\n" +
            "    </select><br />\n" +
            "    <input type=\"submit\" value=\"Calculate\" />\n" +
            "    </fieldset>\n" +
            "</form>\n" +
            "</body>\n" +
            "</html>";

    private static final double IN_TO_METER = 0.0254;
    private static final double FT_TO_METER = 0.3048;
    private static final double MI_TO_METER = 1609.344;

    public static void main(String[] args) {
        Javalin.create()
                .get("/", ctx -> {
                    ctx.html(WEBPAGE);
                })
                .post("/convert", ctx -> {
                    double value = Double.parseDouble(ctx.formParam("value"));
                    String fromUnit = ctx.formParam("sunit");
                    String toUnit = ctx.formParam("tunit");
                    double result = convert(value, fromUnit, toUnit);
                    ctx.result(Double.toString(result));
                })
                .start(9000);
    }

    /**
     * Function to get the conversion unit for a given unit.
     * @param unit The string representation of the unit. Supported units are inches (in), feet (ft), miles (mi) and metres (m).
     * @return The conversion unit for the given unit as a double.
     */
    public static double getConversionUnit(String unit) {
        return switch (unit) {
            case "in" -> IN_TO_METER;
            case "ft" -> FT_TO_METER;
            case "mi" -> MI_TO_METER;
            case "m" -> 1.0;
            default -> Double.NaN;
        };
    }

    /**
     *  Function to convert between units of length. The units supported are inches (in), feet (ft), miles (mi) and metres (m).
     *  @param value The value to convert.
     *  @param fromUnit The unit to convert from.
     *  @param toUnit The unit to convert to.
     *  @return The converted value.
     */
    public static double convert(double value, String fromUnit, String toUnit) {
        double fromUnitInMeters = getConversionUnit(fromUnit);
        double toUnitInMeters = getConversionUnit(toUnit);

        // If the conversion unit is not supported, return NaN.
        if (Double.isNaN(fromUnitInMeters) || Double.isNaN(toUnitInMeters)) {
            return Double.NaN;
        }

        return value * fromUnitInMeters / toUnitInMeters;
    }

}