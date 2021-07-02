package ddeliopoulos.github.gardenjournal.shared;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements
        AttributeConverter<Color, String> {

    private final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Color color) {
        return color.getRed() + SEPARATOR +
                color.getGreen() + SEPARATOR +
                color.getBlue();
    }

    /**
     * Convert a String with format red|green|blue|alpha
     * to a Color object
     */
    @Override
    public Color convertToEntityAttribute(String colorString) {
        String[] rgb = colorString.split(SEPARATOR);
        return new Color(
                Integer.parseInt(rgb[0]),
                Integer.parseInt(rgb[1]),
                Integer.parseInt(rgb[2])
        );
    }
}

