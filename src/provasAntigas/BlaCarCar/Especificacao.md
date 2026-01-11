# Especificações - BlaCarCar

## Informações

Período: 2025.2

Estágio: 1º (No dia 18/12/2025)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vSPy4uMuB8rhLp_TvwfYUftmfCpLOdryn7F5RvuoJr7rZhZYCZfee7O9q3kvNVFYR_iR2ESsK_KJuyK/pub)

## Diagrama UML

![Diagrama UML do BlaCarCar](../../../diagramas/diagramaBlaCarCar.png)

## Notação Modeligado

```
Main
association BlaCarCar
---
---
+ main(String[]: args): void
---


BlaCarCar
composes Passageiro
composes Viagem
---
- passageiros: List<Passageiro>
- rotas: List<Viagem>
---
+ BlaCarCar()
+ cadastrarViagem(motorista: String, descricao: String, vagas: int, contato: String, pontos: String[]): int
+ cadastrarPassageiro(nome: String, cpf: String, link: String, pontos: String[]): boolean
+ cadastrarPassageiro(nome: String, cpf: String, pontos: String[]): boolean
+ atualizarLinkPerfil(cpf: String, novoLink: String): void
+ listarPassageiros(): String[]
+ solicitarVaga(cpf: String, indexViagem: int): void
+ listarPassageirosInscritosViagem(indexViagem: int): String[]
+ listarPassageirosConfirmadosViagem(indexViagem: int): String[]
+ calcularCompatibilidade(cpf: String, indexViagem: int): int
+ listarPassageirosInscritosCompativeis(indexViagem: int, compatibilidade: int): String[]
+ confirmarPassageiros(indexViagem: int, compatibilidade: int): String[]
- buscaPassageiroCPF(cpf: String): int
---


Passageiro
association Viagem
---
- nome: String
- cpf: String
- pontosFrequentes: String[]
- redeSocial: String
---
+ Passageiro(String: nome, String: cpf, String: redeSocial, String[]: pontosFrequentes)
+ Passageiro(String: nome, String: cpf, String[]: pontosFrequentes)
+ hashCode(): int
+ equals(Object: o): boolean
+ toString(): String
+ calculaCompatibilidade(Viagem: viagem): int
+ solicitarVaga(Viagem: viagem): void
+ alterarLinkRedeSocial(String: link): void
+ getNome(): String
+ getCpf(): String
+ getPontosFrequentes(): String[]
+ getRedeSocial(): String
+ setNome(String: nome): void
+ setPontosFrequentes(String[]: pontosFrequentes): void
---

Viagem
---
- motorista: String
- descricao: String
- vagas: int
- contato: String
- pontosParada: String[]
- inscritos: List<Passageiro>
- confirmados: List<Passageiro>
---
+ Viagem(String: motorista, String: descricao, int: vagas, String: contato, String[]: pontosParada)
+ hashCode(): int
+ equals(Object: o): boolean
+ toString(): String
+ adicionarInscrito(Passageiro: passageiro): boolean
+ confirmarInscritos(int: compatibilidade): void
+ getArrayInscritos(): String[]
+ getArrayConfirmados(): String[]
+ getInscritosCompativeis(int: compatibilidade): String[]
+ getMotorista(): String
+ getDescricao(): String
+ getPontosParada(): String[]
+ getContato(): String
+ setMotorista(String: motorista): void
+ setDescricao(String: descricao): void
+ setVagas(int: vagas): void
+ setPontosParada(String[]: pontosParada): void
---
```
