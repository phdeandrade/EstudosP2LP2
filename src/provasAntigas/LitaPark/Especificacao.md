# Especificações - LitaPark 

## Informações: 

Período: 2018.2

Estágio: 1º (No dia 27/09/2018)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vST9157TxUE9yAJUa3BfTLgk7eYcAzVJMqFDeDGsriByT7Omi4DrjPKLsxYI7Ni-VvGZGvkBwLu2-Oh/pub)

## Diagrama UML do Sistema

![Diagrama UML do LitaPark](../../../diagramas/diagramaLitaPark.png)

## Notação Modeligado

```
Main
association LitaPark
---
---
+ main(args: String[]): void
---


LitaPark
composes Vaga
---
- vagas: Vaga
- lucro: double
---
+ LitaPark(int: quantidade)
+ LitaPark()
+ estacionarCarroVaga(hora: LocalTime, String: placa): boolean
+ liberarVaga(LocalTime: hora, String: placa): boolean
+ exibirPainelVagasLivres(): String
+ localizarCarro(String: placa): String
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
+ Vaga(String: setor, int: posicao)
+ hashCode(): int
+ equals(Object: o): boolean
+ toString(): String
+ estacionar(String: placa, LocalTime: hora): void
+ liberar(): void
+ getPlaca(): String
+ getHora(): LocalTime
+ getSetor(): String
+ getPosicao(): int
+ isOcupada(): boolean
+ setPlaca(String: placa): void
+ setOcupada(boolean: ocupada): void
+ getLocalizacao(): String
---
```
