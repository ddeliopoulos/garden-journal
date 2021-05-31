package ddeliopoulos.github.gardenjournal.plant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PlantColorConverter implements
        AttributeConverter<PlantColor, String> {

    private final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(PlantColor color) {
        return color.getRed() + SEPARATOR +
                color.getGreen() + SEPARATOR +
                color.getBlue();
    }

    /**
     * Convert a String with format red|green|blue|alpha
     * to a Color object
     */
    @Override
    public PlantColor convertToEntityAttribute(String colorString) {
        String[] rgb = colorString.split(SEPARATOR);
        return new PlantColor(
                Integer.parseInt(rgb[0]),
                Integer.parseInt(rgb[1]),
                Integer.parseInt(rgb[2])
        );
    }
}

