
### View
- [ ] CadastroProfessor
- [ ] CadastroAluno
- [ ] CadastroDisciplina
- [ ] ExibirProfessores			- Com pesquisa
- [x] ExibirAlunos				- Com pesquisa
- [ ] ExibirDisciplinas

### Controller
- [ ] CadastroProfessorController
- [x] CadastrorAlunoController
- [ ] CadastroDisciplinaController
- [ ] ExibirProfessoresController			- Com pesquisa
- [x] ExibirAlunosController				- Com pesquisa
- [ ] ExibirDisciplinasController

### Model
- [x] DataSource
- [x] BaseModel
- [x] ProfessorDAO
- [x] AlunoDAO
- [x] DisciplinaDAO
- [x] Professor
- [x] Aluno
- [x] Disciplina

### Os dados serão armazenados em arquivos atravéz de ObjectInputStream e ObjectOutputStream em aquivos *.osf (Object Stream File)

- Para facilitar a implementação dos DAOs, eu implementei uma classe chamada DataSource.
- Essa classe consegue manipular (inserir, modificar, ler e deletar) objetos (que extendão Serializable e BaseModel).
- Os DAOs extendem essa classe, e definem qual o tipo do objeto e em qual arquivo os objetos serão gravados.

### DataFiles
- [x] ProfessorStorage.osf
- [x] AlunoStorage.osf
- [x] DisciplinaStorage.osf