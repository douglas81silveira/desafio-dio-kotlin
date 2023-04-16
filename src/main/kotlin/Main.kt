enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val id: Int, val nome: String, val email: String) {

    override fun toString(): String {
        return "Usuario(id=$id, nome=$nome, email=$email)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            inscritos.add(usuario)
        }
    }
}

fun main() {
    val cursoBasico = ConteudoEducacional ("Curso básico de lógica de programacao", 5)
    val cursoKotlin1 = ConteudoEducacional ("Curso Kotlin I", 20)
    val cursoKotlin2 = ConteudoEducacional ("Curso Kotlin II", 50)
    val cursoKotlin3 = ConteudoEducacional ("Curso Kotlin III", 35)

    val aluno1 = Usuario(1,"Douglas Silveira", "douglas@gmail.com")
    val aluno2 = Usuario(2, "Zé do Ico", "zedoico@gmail.com")

    val conteudosKotlin = listOf(cursoBasico, cursoKotlin1, cursoKotlin2, cursoKotlin3)
    val formacao = Formacao("Formacao Kotlin do zero ao avançado", Nivel.AVANCADO, conteudosKotlin)

    formacao.matricular(aluno1, aluno1, aluno2)

    val copiaInscritos = formacao.inscritos
    println("Alunos inscritos na ${formacao.nome}: ")
    for (inscrito in copiaInscritos) {
        println(inscrito.nome)
    }
}