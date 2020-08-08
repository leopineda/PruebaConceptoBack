package fi.dto;

public class FiltroDTO {
    /**
     * Identificador de la carrera
     */
    private int carrera;

    /**
     * Identificador del grupo
     */
    private int grupo;

    /**
     * Identificador de la materia
     */
    private int materia;

    /**
     * Identificador del semestre
     */
    private int semestre;

    /**
     * Nombre de alumno o número de cuenta
     */
    private String alumno;

    /**
     * Constructor.
     */
    public FiltroDTO() {
        super();
    }

    /**
     * Recupera el valor de {@code carrera}
     *
     * @return Valor de {@code carrera}
     */
    public int getCarrera() {
        return carrera;
    }

    /**
     * Establece el valor de {@code carrera}
     *
     * @param carrera Valor de {@code carrera}
     */
    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    /**
     * Recupera el valor de {@code grupo}
     *
     * @return Valor de {@code grupo}
     */
    public int getGrupo() {
        return grupo;
    }

    /**
     * Establece el valor de {@code grupo}
     *
     * @param grupo Valor de {@code grupo}
     */
    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    /**
     * Recupera el valor de {@code materia}
     *
     * @return Valor de {@code materia}
     */
    public int getMateria() {
        return materia;
    }

    /**
     * Establece el valor de {@code materia}
     *
     * @param materia Valor de {@code materia}
     */
    public void setMateria(int materia) {
        this.materia = materia;
    }

    /**
     * Recupera el valor de {@code semestre}
     *
     * @return Valor de {@code semestre}
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el valor de {@code semestre}
     *
     * @param semestre Valor de {@code semestre}
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Recupera el valor de {@code alumno}
     *
     * @return Valor de {@code alumno}
     */
    public String getAlumno() {
        return alumno;
    }

    /**
     * Establece el valor de {@code alumno}
     *
     * @param alumno Valor de {@code alumno}
     */
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
