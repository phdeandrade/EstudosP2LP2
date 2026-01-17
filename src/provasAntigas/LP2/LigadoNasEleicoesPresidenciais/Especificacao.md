# Especificações - LigadoNasEleicoesPresidenciais

## Informações

Período: 2018.1

Estágio: 1º (No dia 17/05/2018)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vScJ0a_3f_-BE5nmGpVoHbGQ05esJfFn4Tzq--jOVJfs0g5auAnWQsitrgcrsOXfTVoaIHiGYGN8Lv7/pub)

## Diagrama UML

![Diagrama UML do HugsAndSmiles](../../diagramas/diagramasLP2/diagramaLigadoNasEleicoesPresidenciais.png)

## Notação Modeligado

```
Main
association Urna
---
---
+ main(args: String[]): void
---

Urna
composes RegistroVotos
composes Candidato
---
- CANDIDATOS: Candidato[]
- votos: RegistroVoto[]
- iVotos: int
---
+ Urna()
+ votar(tituloEleitor: int, numeroCandidato: int, horaDoVoto: String): boolean
+ listarVotos(): String
+ checarUrna(): boolean
- buscaCandidatoId(numero: int): int
- votoJaRegistrado(tituloEleitor: int): boolean
---

RegistroVotos
---
- tituloEleitor: int
- horaVotacao: String
---
+ RegistroVoto(tituloEleitor: int, horaVotacao: String)
+ hashCode(): int
+ equals(obj: Object): boolean
+ toString(): String
+ getTituloEleitor(): int
+ getHoraVotacao(): String
---

Candidato
---
- nome: String
- partido: String
- id: int
- votos: int
---
+ Candidato(nome: String, partido: String, id: Integer)
+ hashCode(): int
+ equals(obj: Object): boolean
+ toString(): String
+ adicionarVoto(): void
+ listarVotos(): String
+ alterarNome(novoNome: String): void
+ getNome(): String
+ getPartido(): String
+ getId(): int
+ getVotos(): int
---
```
