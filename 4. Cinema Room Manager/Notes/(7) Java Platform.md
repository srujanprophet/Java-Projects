# Java Platform
* The term “Java” is used for many purposes in the world of software development: it doesn’t only mean the programming language.
* In general, Java refers to a software platform: it includes some computer applications and documentation.

## 1. JVM
* Programs in the world of Java run via a special application called **Java Virtual Machine**, or **JVM**. It is usually a separate program installed on the device.
* In short, JVM represents a virtual computer that corresponds to the **JVM specification** document.
* Different platforms have different JVMs, but since all JVMs can behave identically: from the point of view of the program, nothing changes.
* It is one of the main concepts of Java Platform : **write once, run anywhere**. It means that a single program can run on different computers thanks to JVMs installed there.
* So, the most programs in the world of Java aren’t bound to a device. This concept is also frequently called **platform-independence**, or **portability**.

## 2. JVM languages
* Java Platform allows using more than one programming language to create programs. This is achieved by the design of JVM: it doesn’t know anything in particular about any particular programming language.
* It can understand only **Java bytecode**, a representation of a program in a very compact form. If the tools for a programming language can generate Java bytecode, programs written in the language can run using JVM. 
* Such languages are often called **JVM languages**. They include **Java** itself, **Kotlin**, **Scala**, **Groovy**, **Clojure**, and others.
* Bytecode generation is done automatically by special applications called **compilers**.
* If needed, bytecode can be managed using special tools like ASM framework or Javassist library.

## 3. Conclusion
* JVM languages have tools that produce Java bytecode. JVMs are separate for different computer devices but they can all run Java bytecode in the same way, making programs in the world of Java platform-independent.
* All of this makes Java Platform overwhelmingly diverse and handy for many different use cases.