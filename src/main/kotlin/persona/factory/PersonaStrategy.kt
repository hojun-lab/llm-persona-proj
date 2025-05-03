package rojojun.persona.factory

import rojojun.persona.Persona

interface PersonaStrategy {
    fun parsePersonas(filelist: List<String>): List<Persona>
}