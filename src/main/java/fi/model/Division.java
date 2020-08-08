package fi.model;

import javax.persistence.*;

@Entity
@Table(name = "division")
public class Division {

    /**
     * Identificador del objeto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    public Division() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
