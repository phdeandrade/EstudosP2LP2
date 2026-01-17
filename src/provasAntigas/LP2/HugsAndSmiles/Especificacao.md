# Especificações - HugsAndSmiles

## Informações

Período: 2019.2

Estágio: 1º (No dia 16/04/2019)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vRWiM4knsnIoVIt6ZvjMFWndyi-hVvGze1rIy1UVT_fGqeMmVwvQx9ERiX0Mi-f2IBYlLQH4_3uueDX/pub)

## Diagrama UML

![Diagrama UML do HugsAndSmiles](../../diagramas/diagramasLP2/diagramaHugsAndSmiles.png)

## Notação Modeligado

```
Main
association DeliveryOfDay
---
---
+ main(args: String[]): void
---

DeliveryOfDay
composes Delivery
composes Cliente
---
- clientes: Cliente[]
- entregas: Delivery[]
- iEntregas: int
---
+ DeliveryOfDay(clientes: Cliente[])
+ DeliveryOfDay(clientes: Cliente[], capacidadeMaxima: int)
+ addDelivery(d: Delivery): boolean
+ listDoD(): String
+ listFinished(): String
+ finishDelivery(pos: int): String
- isClienteAdded(idCliente: int): boolean
---

Delivery
---
- produto: String
- fornecedor: String
- idCliente: int
- status: String
---
+ Delivery(produto: String, fornecedor: String, idCliente: int)
+ hashCode(): int
+ equals(o: Object): boolean
+ toString(): String
+ alterarStatus(status: String): void
+ getStatus(): String
+ getProduto(): String
+ getFornecedor(): String
+ getIdCliente(): int
---

Cliente
---
- id: int
- nome: String
- endereco: String
---
+ Cliente(id: int, nome: String, endereco: String)
+ hashCode(): int
+ equals(o: Object): boolean
+ toString(): String
+ getId(): int
+ getNome(): String
+ getEndereco(): String
---

```
