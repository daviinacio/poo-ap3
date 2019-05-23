# Trabalho (AP3) de Programação Orientada a Objetos
## Aluno: Davi Inácio

## [Orientações da Atividade](/planejamento/orientações.md)

Suponha que você foi contratado por uma Escola para informatizar o seu sistema de controle acadêmico que seja capaz de:

Cadastrar professores Cadastrar disciplinas Cadastrar alunos Exibir a listagem de professores Exibir a listagem de alunos Exibir a listagem de disciplinas Pesquisar e exibir um professor específico, bem como que disciplinas ministra(Opcional) Pesquisar e exibir um aluno específico, bem como que disciplinas cursa (Opcional) OBS:

Deve-se implementar
- MVC
- AWT e/ou Swing
- Manipulação de Arquivos

## [Planejamento](/planejamento/planejamento.md)

### View
- [x] CadastroProfessor
- [x] CadastroAluno
- [x] CadastroDisciplina
- [x] ExibirProfessores			- Com pesquisa
- [x] ExibirAlunos				- Com pesquisa
- [x] ExibirDisciplinas

### Controller
- [x] CadastroProfessorController
- [x] CadastrorAlunoController
- [x] CadastroDisciplinaController
- [x] ExibirProfessoresController			- Com pesquisa
- [x] ExibirAlunosController				- Com pesquisa
- [x] ExibirDisciplinasController

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

[Modelagem de dados](/planejamento/modelage%20de%20dados.md)

### Relações

- [x] Professor
```
id:INTEGER
nome:STRING
diciplina:List<DISCIPLINA>
```
	
- [x] Aluno
```
id:INTEGER
nome:STRING
diciplina:List<DISCIPLINA> 
```
	
	
- [x] Disciplina
```
id:INTEGER
nome:STRING
```
	
	
### Cardinalidades

```
Professor 1 ------- 1..* Disciplina
Aluno 1..* ------- 1..* Disciplina
```


