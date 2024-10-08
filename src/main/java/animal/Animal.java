package animal;


public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;
    private String years;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String say() {
        return ("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    @Override
    public String toString() {
        String s = "Привет! меня зовут " + name + ", мне " + age + " " + countAge(getAge()) + ", я вешу - " + weight + " кг, мой цвет - " + color;
        return s;
    }

    public Animal(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public String countAge(int age) {

        int count = age % 100;
        if (count >= 5 && count <= 20) {
            years = "лет";
        } else {
            count = count % 10;
            if (count == 1) {
                years = "год";
            } else if (count >= 2 && count <= 4) {
                years = "года";
            } else {
                years = "лет";
            }
        }
        return years;
    }
}
