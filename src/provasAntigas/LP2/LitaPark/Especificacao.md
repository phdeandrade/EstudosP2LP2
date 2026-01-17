# Especificações - LitaPark 

## Informações: 

Período: 2018.2

Estágio: 1º (No dia 27/09/2018)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vST9157TxUE9yAJUa3BfTLgk7eYcAzVJMqFDeDGsriByT7Omi4DrjPKLsxYI7Ni-VvGZGvkBwLu2-Oh/pub)

## Diagrama UML do Sistema

![Diagrama UML do LitaPark](../../diagramas/diagramasLP2/diagramaLitaPark.png)

## Notação Modeligado

```
Main
association LitaPark
---
---
+ main(String[]: args): void
---

LitaPark
composes Vaga
---
- vagas: Vaga
- lucro: double
---
+ LitaPark(quantidade: int)
+ LitaPark()
+ estacionarCarroVaga(placa: String, hora: LocalTime): boolean
+ liberarVaga(hora: LocalTime, placa: String): boolean
+ exibirPainelVagasLivres(): String
+ localizarCarro(placa: String): String
+ imprimirLucroTotal(): double
---

Vaga
---
- placa: String
- hora: LocalTime
- setor: String
- posicao: int
- ocupada: boolean
---
+ Vaga(setor: String, posicao: int)
+ hashCode(): int
+ equals(obj: Object): boolean
+ toString(): String
+ estacionar(placa: String, hora: LocalTime): void
+ liberar(): void
+ getPlaca(): String
+ getHora(): LocalTime
+ getSetor(): String
+ getPosicao(): int
+ isOcupada(): boolean
+ setPlaca(placa: String): void
+ setOcupada(ocupada: boolean): void
+ getLocalizacao(): String
---

```
