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
