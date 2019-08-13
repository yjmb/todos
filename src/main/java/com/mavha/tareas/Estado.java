package com.mavha.tareas;

public enum Estado {
    /**
     * Indica que la tarea no ha iniciado.
     */
    POR_INICIAR,
    /**
     * Indica que la tarea inicio pero no ha finalizado.
     */
    EN_PROGRESO,
    /**
     * Indica que la tarea finalizo correctamente.
     */
    FINALIZADO,
    /**
     * Indica que el proceso finalizo con errores.
     */
    ERROR;
}
