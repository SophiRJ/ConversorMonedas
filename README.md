
# 💱 Conversor de Monedas con API Exchangerate y Java

Este proyecto es una aplicación de consola en Java que permite al usuario:

- Ver códigos de monedas disponibles (desde un CSV).
- Realizar conversiones entre monedas usando la API de [ExchangeRate-API](https://www.exchangerate-api.com/).
- Procesar y mostrar la respuesta de forma clara usando Gson.

---

## 📦 Requisitos

- Java 11 o superior
- IntelliJ IDEA o cualquier IDE Java
- Conexión a Internet (para acceder a la API)
- Dependencia de Gson

---

## 🔧 Instalación

1. Clona el repositorio o descarga los archivos.
2. Asegúrate de tener el archivo `monedas.csv`.
3. Añade Gson como dependencia:

### 👉 Si usas Maven

Agrega esto a tu `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```

### 👉 Si no usas Maven

Descarga el `.jar` desde [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson) y añádelo como biblioteca en IntelliJ:  
`File → Project Structure → Libraries → +`

---

## 📁 Estructura del Proyecto

```
src/
├── modelo/
│   ├── CambioMoneda.java
│   ├── RespuestaCambio.java
├── principal/
│   └── Principal.java
├── monedas.csv
```

---

## ▶️ Cómo usar

1. Ejecuta el programa.
2. Selecciona una opción:
   - `1` → Ver códigos de monedas (desde el CSV).
   - `2` → Realizar conversión.
3. Introduce:
   - Código ISO de la moneda de origen (por ejemplo, `EUR`).
   - Código ISO de la moneda destino (por ejemplo, `USD`).
   - Cantidad a convertir (puede ser decimal con `,` ).

---

## 🌐 Ejemplo de Uso

```
Conversor Monedas
Opciones:
1-> Ver codigos monedas.
2-> Realizar Conversion
2
Introduzca el codigo de la moneda de origen: EUR
Introduzca la moneda de destino: BOB
Introduzca la cantidad a cambiar: 100,00

✅ Resultado de conversión:
100.00 EUR → 801.03 BOB
Tipo de cambio: 1 EUR = 8.0103 BOB
```

---

## 🛠️ Notas Técnicas

- La clase `CambioMoneda` maneja la entrada de usuario y la lectura del CSV.
- La clase `Principal` construye la petición HTTP, consume la API y formatea la respuesta.
- La clase `RespuestaCambio` representa el JSON devuelto por la API y es usada por Gson.

---

## 🔐 API Key

Necesitas una API Key válida de [ExchangeRate-API](https://www.exchangerate-api.com/).  
Reemplázala en el archivo `Principal.java`:

```java
String apiKey = "AQUI_TU_API_KEY";
```
---

## 📜 Licencia

Este proyecto es libre para propósitos educativos.
