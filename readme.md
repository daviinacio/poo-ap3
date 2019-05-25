# Trabalho (AP3) de Programação Orientada a Objetos
## Aluno: Davi Inácio

## Prints
|Main View|
|:-------:|
|![Main View](/prints/Win_MainView.png)|

|Exibir Alunos|Exibir Professores|Exibir Disciplinas|
|:-----------:|:----------------:|:----------------:|
|![Exibir Alunos](/prints/Win_ExibirAlunos.png)|![Exibir Professores](/prints/Win_ExibirProfessores.png)|![Exibir Disciplinas](/prints/Win_ExibirDisciplinas.png)|

|Cadastro Alunos|Cadastro Professores|Cadastro Disciplinas|
|:-----------:|:----------------:|:----------------:|
|![Cadastro Aluno](/prints/Win_CadastroAluno.png)|![Cadastro Professor](/prints/Win_CadastroProfessor.png)|![Cadastro Disciplina](/prints/Win_CadastroDisciplina.png)|



## [Orientações da Atividade](/planejamento/orientações.md)

Suponha que você foi contratado por uma Escola para informatizar o seu sistema de controle acadêmico que seja capaz de:

Cadastrar professores Cadastrar disciplinas Cadastrar alunos Exibir a listagem de professores Exibir a listagem de alunos Exibir a listagem de disciplinas Pesquisar e exibir um professor específico, bem como que disciplinas ministra(Opcional) Pesquisar e exibir um aluno específico, bem como que disciplinas cursa (Opcional) OBS:

Deve-se implementar
- MVC
- AWT e/ou Swing
- Manipulação de Arquivos

## [Planejamento](/planejamento/planejamento.md)

### View
- [x] [CadastroAluno](/src/com/daviinacio/poo/ap3/view/CadastroAluno.java)
- [x] [CadastroDisciplina](/src/com/daviinacio/poo/ap3/view/CadastroDisciplina.java)
- [x] [CadastroProfessor](/src/com/daviinacio/poo/ap3/view/CadastroProfessor.java)
- [x] [ExibirAlunos](/src/com/daviinacio/poo/ap3/view/ExibirAlunos.java)
- [x] [ExibirDisciplinas](/src/com/daviinacio/poo/ap3/view/ExibirDisciplinas.java)
- [x] [ExibirProfessores](/src/com/daviinacio/poo/ap3/view/ExibirProfessores.java)

### Controller
- [x] [CadastroAlunoController](/src/com/daviinacio/poo/ap3/controller/CadastroAlunoController.java)
- [x] [CadastroDisciplinaController](/src/com/daviinacio/poo/ap3/controller/CadastroDisciplinaController.java)
- [x] [CadastroProfessorController](/src/com/daviinacio/poo/ap3/controller/CadastroProfessorController.java)
- [x] [ExibirAlunosController](/src/com/daviinacio/poo/ap3/controller/ExibirAlunosController.java)
- [x] [ExibirDisciplinasController](/src/com/daviinacio/poo/ap3/controller/ExibirDisciplinasController.java)
- [x] [ExibirProfessoresController](/src/com/daviinacio/poo/ap3/controller/ExibirProfessoresController.java)

### Model
- [x] [DataSource](/src/com/daviinacio/poo/ap3/model/DataSource.java)
- [x] [BaseModel](/src/com/daviinacio/poo/ap3/model/BaseModel.java)
- [x] [AlunoDAO](/src/com/daviinacio/poo/ap3/model/AlunoDAO.java)
- [x] [DisciplinaDAO](/src/com/daviinacio/poo/ap3/model/DisciplinaDAO.java)
- [x] [ProfessorDAO](/src/com/daviinacio/poo/ap3/model/ProfessorDAO.java)
- [x] [Aluno](/src/com/daviinacio/poo/ap3/model/Aluno.java)
- [x] [Disciplina](/src/com/daviinacio/poo/ap3/model/Disciplina.java)
- [x] [Professor](/src/com/daviinacio/poo/ap3/model/Professor.java)

### Os dados serão armazenados em arquivos atravéz de ObjectInputStream e ObjectOutputStream em aquivos *.osf (Object Stream File)

- Para facilitar a implementação dos DAOs, eu implementei uma classe chamada DataSource.
- Essa classe consegue manipular (inserir, modificar, ler e deletar) objetos (que extendão Serializable e BaseModel).
- Os DAOs extendem essa classe, e definem qual o tipo do objeto e em qual arquivo os objetos serão gravados.

### DataFiles
- [x] ProfessorStorage.osf
- [x] AlunoStorage.osf
- [x] DisciplinaStorage.osf

## [Modelagem de dados](/planejamento/modelage%20de%20dados.md)

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


