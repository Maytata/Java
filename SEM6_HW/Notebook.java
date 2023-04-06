public class Notebook {

    private final String model;
    private final String OS;
    private final int screensize;
    private final int ROM;
    private final int memory;
    private final String color;
    private final double price;

    public Notebook(String model, String OS, int ROM, int memory, int screensize, double price, String color) {
        this.model = model;
        this.OS = OS;
        this.ROM = ROM;
        this.memory = memory;
        this.screensize = screensize;
        this.price = price;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getROM() {
        return ROM;
    }

    public double getPrice() {
        return price;
    }

    public String getOS() {
        return OS;
    }

    public int getScreensize() {
        return screensize;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        String nb_info = "";
        nb_info += "Notebook ";
        nb_info += model + "\n";
        nb_info += "screensize:    " + screensize + "\"\n";
        nb_info += "OS:            " + OS + "\n";
        nb_info += "ROM:           " + ROM + "\n";
        nb_info += "memory:        " + memory + "\n";
        nb_info += "color:         " + color + "\n";
        nb_info += "price:         " + price + "$ \n\n";

        return nb_info;
    }
}
