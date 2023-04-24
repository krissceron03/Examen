public class Persona implements Comparable<Persona>{
    String nombreCompleto;
    int id, edad, prioridad, amigos;

    public Persona(String nombreCompleto, int id, int edad, int prioridad, int amigos) {

        this.nombreCompleto = nombreCompleto;
        this.id = id;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }
    @Override
    public int compareTo(Persona per) {

        return Integer.compare(per.prioridad,this.prioridad);

    }
}

