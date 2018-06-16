package p01_Class_Box;

public class Box {
    private Double length;
    private Double width;
    private Double height;

    public Box(Double length, Double width, Double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private Double getLength() {
        return this.length;
    }
    private void setLength(Double length){
        if(length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private Double getWidth() {
        return this.width;
    }
    private void setWidth(Double width){
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private Double getHeight() {
        return this.height;
    }

    private void setHeight(Double height){
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public Double getSurfaceArea() {
        return (2 * this.getLength() * this.getWidth()) +
                (2 * this.getLength() * this.getHeight()) +
                (2 * this.getWidth() * this.getHeight());
    }

    public Double getLateralSurfaceArea() {
        return (2 * this.getLength() * this.getHeight()) +
                (2 * this.getWidth() * this.getHeight());
    }

    public Double getVolume() {
        return this.getHeight() * this.getLength() * this.getWidth();
    }

}
