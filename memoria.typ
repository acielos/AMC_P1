#import "@preview/codly:1.3.0": *
#import "@preview/codly-languages:0.1.1": *
#show: codly-init.with()

#import "@preview/in-dexter:0.7.2": *
#let ASIGNATURA = [Algorítmica y Modelos de Computación \ Departamento de Tecnologías de la Información]
#let TITULO = "ANÁLISIS DE ALGORITMOS EXHAUSTIVOS, CON PODA Y ALGORITMOS DIVIDE Y VENCERÁS"
#let ESTUDIANTES = ([Antonio Cielos Bueno],[Isabela Ortigosa de Araujo])
#let PROFESORES = ([Luis Gutiérrez Jerez],)
#let PIE_PAGINA = []
#let LOGO = "logo.png"

#show image: it => { align(center, it) }




#align(center+top)[
  #text(size: 10pt)[
    #upper(ASIGNATURA) 
  ]
  #line(length: 100%, stroke: (thickness: 3pt, cap: "round"))
  #text(TITULO, size: 20pt, weight: "bold")
  #line(length: 100%, stroke: (thickness: 3pt, cap: "round"))
]

#align(center)[
  #image(width: 65%, LOGO)
]

#align(bottom)[
  #let valid_array(arr, default) = if (type(arr) == array and arr.len() > 0) {
    default
  }

  #align(
    bottom,
    block[
      #set align(top)
      #grid(
        columns: (1.7fr, 1pt, 1fr),
        row-gutter: 10pt,
        valid_array(ESTUDIANTES)[*Alumnos:*],
        [],
        valid_array(PROFESORES)[*Profesor:*],

        grid(
          columns: 1fr, row-gutter: 10pt,
          ..ESTUDIANTES.map(it => {
            if type(it) == array {
              let nome = it.at(0)
              let nusp = it.at(1)
              [- #nome #text(size: 9pt)[ | NUSP: #nusp ]]
            } else {
              [- #it]
            }
          })
        ),
        [],
        grid(
          columns: 1fr, row-gutter: 10pt,
          ..PROFESORES.map(nome => {
            [- #nome]
          })
        ),
      )
      #v(1cm)
    ],
  )
]

#align(center + bottom)[
    #PIE_PAGINA\
    Curso académico 2025 / 2026
]

#set par(justify: true)

#show raw.where(block: true): it => {
  set align(left)
  block(inset: (left: 1cm), it)
}

#pagebreak()

= 1. Introducción
\ 
#h(1cm) El objetivo de esta práctica es desarrollar algoritmos para resolver un problema clásico de búsqueda 
sobre conjuntos de puntos: la búsqueda del punto más cercano a otro. A partir de un conjunto de puntos situados
en un plano $P = {(x#sub[1], y#sub[1]), (x#sub[2], y#sub[2]), ..., (x#sub[n], y#sub[n])}$, se debe encontrar el par de puntos cuya distancia
euclídea sea mínima. La distancia entre dos puntos $p#sub[i] = (x#sub[i], y#sub[i])$ y $p#sub[j] = (x#sub[j], y#sub[j])$ se calcula
como $sqrt((x#super[i]-x#super[j])#super[2] + (y#super[i]-y#super[j])#super[2])$.

Para abordar dicho problema, se plantean cuatro estrategias:

+ *Búsqueda exhaustiva* que analiza todos los pares posibles, con complejidad $O(n#super[2])$, efectiva para conjuntos pequeños pero ineficiente para grandes volúmenes de datos.
+ *Búsqueda  con poda* que ordena los puntos según una coordenada y descarta comparaciones innecesarias, mejorando el rendimiento con un costo mínimo de ordenación $O(n log n)$
+ *Técnica divide y vencerás*, que divide el conjunto en dos subconjuntos, aplica recursividad y combina resultados considerando luego los pares que cruzan la división, con una complejidad asintótica de $O(n log n)$
+ *Mejora del divide y vencerás* ordenando los puntos en la franja intermedia también por la coordenada secundaria para evitar el peor caso del algoritmo básico y mantener la eficiencia en distribuciones desfavorables
En esta memoria explicaremos la implementación práctica de estas estrategias en Java. De la misma manera
explicaremos el análisis teórico y experimental de dichas implementaciones así como el rendimiento de los diferentes algoritmos.

= 2. Estrategias de Búsqueda
\ 
#h(1cm) Las estrategias de búsqueda para resolver el problema del punto más cercano pueden abordarse
mediante cuatro enfoques principales, cada uno con diferentes niveles de eficiencia y complejidad
\

== 2.1 Primera aproximación: _Búsqueda exhaustiva_
\
#h(1cm) La primera aproximación consiste en analizar todos los pares posibles de puntos del conjunto dado, calculando la distancia euclídea entre ellos y quedándose
con el par cuya distancia sea la menor. Para _n_ puntos, existen $n(n-1)/2$ pares, lo que implica una complejidad temporal de $O(n#super[2])$. Si bien este método es sencillo y
rápido para conjuntos pequeños, su tiempo de ejecución crece exponencialmente a medida que aumenta el tamaño del conjunto, resultado poco óptimo para grandes volúmenes de datos.

== 2.2 Segunda aproximación: _Búsqueda con poda_
\
#h(1cm) En la segunda estrategia, antes de comparar los puntos entre sí, se ordenan en base a una de sus coordenadas (_x_ o _y_), normalmente utilizando un algoritmo rápido con coste $O(n log n)$.
Una vez ordenados, el algoritmo solo compara pares de puntos mientras la diferencia en la coordenada seleccionada sea menor que la distancia mínima hallada hasta el momento. Cuando esa diferencia
supera dicho valor, puede descartarse el resto, ahorrando comparaciones innecesarias.\ \
Este método mantiene una cota inferior teórica de $O(n log n)$ y resulta más eficiente que la búsqueda exhaustiva para la mayoría de los casos.

== 2.3 Tercera aproximación: _Técnica Divide y Vencerás_
\
#h(1cm) El tercer enfoque utiliza la técnica Divide y Vencerás. En este método, se ordenan los puntos por una coordenada y se divide el conjunto en dos subconjuntos de igual tamaño mediante una ñínea vertical imaginaria.
El problema se resuelve recursivamente en cada subconjunto, y después se considera la posible existencia de un par de puntos más cercano que cruce la línea divisoria. Para ello, basta con analizar los puntos que se encuentren
dentro de una franja de anchura $2\u{03B4}$ centrada en la línea, donde $\u{03B4}$ es la mínima distancia encontrada en los subconjuntos. Si a distribución de puntos es uniforme, este método tiene una complejidad asintótica de 
$O(n log n)$.

== 2.4 Cuarta aproximación: _Divide y Vencerás mejorado_
\ 
#h(1cm) En el peor de los casos, si todos los puntos comparten la misma coordenada _x_, es decir, todos están alineados verticalmente, la franja intermedia puede contener todos los puntos, llevando el 
algoritmo al comportamiento de la búsqueda exhaustiva.\ \
La versión mejorada actúa ordenando los puntos de la franja por la coordenada _y_. De este modo, basta con comparar, para cada punto de la franja, únicamente los siguientes 11 puntos en la lista
ordenada, respaldado por un razonamiento geométrico que asegura que no puede haber dos puntos más cercanos a mayor distancia en desplazamientos verticales. Esto garantiza la eficiencia incluso en peor caso,
manteniendo la complejidad en $O(n log n)$. \ \
Estas estrategias ofrecen diferentes compromisos entre simplicidad, rendimiento y robustez ante distintas distribuciones de los datos, permitiendo analizar comparativamente su desempeño en función
del tamaño del conjunto y el patrón de los puntos.

= 4. Ficheros de entrada y formato
\
#lorem(100)
= 5. Desarrollo del programa
= 6. Estudio teórico y análisis de algoritmos de ordenación
= 7. Estudio experimental y comparación de estrategias
= 8. Conclusiones