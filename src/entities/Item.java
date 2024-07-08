package entities;

public class Item {

      private int id;
      private int precio;
      private String nombre;
      private String categoria;

      public Item() {

      }

      public String getCategoria() {
            return categoria;
      }

      public void setCategoria(String categoria) {
            this.categoria = categoria;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNombre() {
            return nombre;
      }

      public void setNombre(String nombre) {
            this.nombre = nombre;
      }

      public int getPrecio() {
            return precio;
      }

      public void setPrecio(int precio) {
            this.precio = precio;
      }

      @Override
      public String toString() {
            return "Item{" + "itemId=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + '}';
      }

}
