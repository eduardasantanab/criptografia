# criptografia

Em criptografia, a Cifra de César, também conhecida como cifra de troca, código de César ou troca
de César, é uma das mais simples e conhecidas técnicas de criptografia. É um tipo de cifra de
substituição na qual cada letra do texto é substituída por outra, que se apresenta no alfabeto à
frente dela um número fixo de vezes. Por exemplo, com uma troca de três posições, A seria
substituído por D, B se tornaria E, e assim por diante. 
A ação de uma cifra de César é mover cada letra do alfabeto um número de posições fixo à frente.
Este exemplo está com uma troca de três posições, então o B no texto normal se torna E no texto
cifrado.

Para criptografar uma mensagem, deve-se simplesmente observar cada letra da mensagem e
escrever a letra correspondente ao deslocamento escolhido. Para descriptografar, deve-se fazer o
contrário.
Veja o exemplo abaixo:
Normal: a ligeira raposa marrom saltou sobre o cachorro cansado
Cifrado: D OLJHLUD UDSRVD PDUURP VDOWRX VREUH R FDFKRUUR FDQVDGR

OBS1: Se o resultado da descriptografia acima não estiver no intervalo 0...25, deve-se adicionar 26 ao resultado
obtido.
Exemplo de descriptografia:
Cifrado: D OLJHLUD UDSRVD PDUURP VDOWRX VREUH R FDFKRUUR FDQVDGR
Normal: a ligeira raposa marrom saltou sobre o cachorro cansado

Foi implementado um programa para realizar o processo de criptografar ou descriptografar uma
mensagem utilizando a cifra de César. O programa solicita ao usuário a escolha da
operação que deseja realizar (1 – Criptografar ou 2 – Decriptografar). Após escolher a operação
que deseja realizar, o usuário deverá digitar o deslocamento que deverá ser utilizado pela cifra de
César para realizar o processo de criptografia ou descriptografia. 
