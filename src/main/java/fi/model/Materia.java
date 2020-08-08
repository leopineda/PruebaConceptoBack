package fi.model;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "materia")
public class Materia {

    /**
     * Identificador del objeto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "clave")
    private String clave;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_materia_padre", nullable = true)
    private Materia materiaPadre;

    @Column(name = "creditos")
    private int creditos;

    @Column(name = "laboratorio_incluido")
    private boolean laboratorioIncluido;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_laboratorio", nullable = true)
    private Materia laboratorio;

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_division", nullable = true)
    private Division division;

    public Materia() {
        super();
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Materia getMateriaPadre() {
        return materiaPadre;
    }

    public void setMateriaPadre(Materia materiaPadre) {
        this.materiaPadre = materiaPadre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public boolean isLaboratorioIncluido() {
        return laboratorioIncluido;
    }

    public void setLaboratorioIncluido(boolean laboratorioIncluido) {
        this.laboratorioIncluido = laboratorioIncluido;
    }

    public Materia getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Materia laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
