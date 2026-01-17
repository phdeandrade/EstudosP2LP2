# Especificações - BlaCarCar

## Informações

Período: 2025.2

Estágio: 1º (No dia 18/12/2025)

Texto de especificação: [Texto](https://docs.google.com/document/d/e/2PACX-1vSPy4uMuB8rhLp_TvwfYUftmfCpLOdryn7F5RvuoJr7rZhZYCZfee7O9q3kvNVFYR_iR2ESsK_KJuyK/pub)

## Diagrama UML

![Diagrama UML do BlaCarCar](../../diagramas/diagramasLP2/diagramaBlaCarCar.png)

## Notação Modeligado

```
Main
association BlaCarCar
---
---
+ main(args: String[]): void
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
+ Passageiro(nome: String, cpf: String, redeSocial: String, pontosFrequentes: String[])
+ Passageiro(nome: String, cpf: String, pontosFrequentes: String[])
+ hashCode(): int
+ equals(o: Object): boolean
+ toString(): String
+ calculaCompatibilidade(viagem: Viagem): int
+ solicitarVaga(viagem: Viagem): void
+ alterarLinkRedeSocial(link: String): void
+ getNome(): String
+ getCpf(): String
+ getPontosFrequentes(): String[]
+ getRedeSocial(): String
+ setNome(nome: String): void
+ setPontosFrequentes(pontosFrequentes: String[]): void
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
+ Viagem(motorista: String, descricao: String, vagas: int, contato: String, pontosParada: String[])
+ hashCode(): int
+ equals(o: Object): boolean
+ toString(): String
+ adicionarInscrito(passageiro: Passageiro): boolean
+ confirmarInscritos(compatibilidade: int): void
+ getArrayInscritos(): String[]
+ getArrayConfirmados(): String[]
+ getInscritosCompativeis(compatibilidade: int): String[]
+ getMotorista(): String
+ getDescricao(): String
+ getPontosParada(): String[]
+ getContato(): String
+ setMotorista(motorista: String): void
+ setDescricao(descricao: String): void
+ setVagas(vagas: int): void
+ setPontosParada(pontosParada: String[]): void
---

```
