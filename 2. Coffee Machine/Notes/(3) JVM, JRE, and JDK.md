# JVM, JRE, and JDK
## 1. Java Virtual Machine (JVM)
* **JVM** is a virtual simulation of a physical computer. It executes Java bytecode class files. **JVM**s are available for many hardware and software platforms. A program compiled to Java bytecode is almost always **platform-independent**.
* Today, there is a variety of **JVM** implementations. For instance, **HotSpot** is the primary reference Java VM implementation.

## 2. Java Runtime Environment (JRE)
* **JRE** is an execution environment for **running** compiled JVM programs. JRE includes Java Virtual Machine (**JVM**) and Java Class Library (**JCL**).
* **JCL** consists of many libraries including input/output, collections, security, classes for parsing XML, user interface toolkits, and many others.
* When we run a compiled program in JRE, JVM uses bytecode class files of both our program and JCL.

## 3. Java Development Kit (JDK)
* **JDK** is a package **to develop** programs for Java Platform. It includes **JRE** and tools for developers, such as Java compiler, debugger, archiver, etc.
* Java compiler (usually it’s the (**javac** tool) translates ***.java** into ***.class**. Several files with ***.class** extensions can be packed together in a single Java Archive (**JAR-file**).
* Other JVM languages such as Kotlin or Scala have their separate compilers, they aren’t bundled with JDK.

## 4. The relationship between JVM, JRE, and JDK
* The following illustrates the relationship between **JVM, JRE, and JDK**
<a href='(3)%20JVM,%20JRE,%20and%20JDK/JVM-JRE-JDK%20%20(1).svg'>JVM-JRE-JDK  (1).svg</a>
* To recap:
	* **JVM** executes Java bytecode;
	* **JRE** includes **JVM** and standard libraries: it is needed **to run** compiled programs;
	* **JDK** includes **JRE** and development tools: it is needed **to develop** programs. As a developer, we need to install **JDK**.
* Before Java 11, if we wanted to run only a Java program, **JRE** was enough. However, since Java 11 was released, for most JVM implementations **JRE** is no longer downloadable as a separate component. If we want to run programs in JVM11 or newer, we have to install **JDK**.
