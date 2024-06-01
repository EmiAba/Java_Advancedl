package F12_Classes_Exc._05Car_Salseman;

public class Car {
   private String model;
   private Engine engine;
   private String weight;
   private String color;

   public Car(String model, Engine engine, String weight, String color) {
      this.model = model;
      this.engine = engine;
      this.weight = (weight != null) ? weight : "n/a";
      this.color = (color != null) ? color : "n/a";
   }

   public Car(String model, Engine engine) {
      this(model, engine, null, null);
   }

   @Override
   public String toString() {
      return String.format("%s:\n%s\nWeight: %s\nColor: %s", model, engine, weight, color);
   }
}
