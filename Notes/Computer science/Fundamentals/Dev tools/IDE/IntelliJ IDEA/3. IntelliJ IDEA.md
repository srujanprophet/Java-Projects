# IntelliJ IDEA
## 1. IntelliJ IDEA
* IntelliJ IDEA is a modern Java IDE developed by JetBrains.
* It has an ergonomic user interface, supports a lot of plugins, and provides a very powerful automatic code completion feature.
* IntelliJ IDEA has two editions: community and enterprise. Both editions support multiple programming languages, including Java, Kotlin, Scala, and some others.

## 2. Creating the first project in IntelliJ IDEA
1. If no project is currently open in IntelliJ IDEA, click **Create New Project** on the Welcome screen. Otherwise, select **File | New | Project**. As a result, the **New Project** wizard opens.
2. In the left-hand pane, select your language (for example, Java or Kotlin). There is also an option to create an empty project without any language support. There can be some options like the JDK (Java Development Kit) that we want to use in our project, just leave them unchanged now.
3. The next pages can propose templates or something else. Now we are going to study the very basics of IntelliJ IDEA, and do everything from scratch, so we aren’t selecting any of the options and we just leave the default. 
4. On the final page, specify the project name (e.g. `HelloWorld`). If necessary, we can change the project location on disk, but we can also use one suggested by IntelliJ IDEA.
5. Click **Finish**.

Wait while IntelliJ IDEA creates the project. When this process is complete, the structure of the new project is shown in the **Project** tool window.
Taking a look at the project structure on the right side of the window. There are two top-level nodes:
* **HelloWorld**. This node represents the project module. The `.idea` folder and the file `HelloWorld.iml` are used to store configuration data for the project and module respectively. The folder src is for the source code.
* **External Libraries.** This is a category that represents all the “external” resources necessary for the development work. The standard files of the project language are placed there. Also, we can add other resources manually.

## 3. Writing
1. In the Project tool window, select the `src` folder and select **File | New**, or **New** from the context menu for the folder `src`.
2. In the New menu, select **File**.
3. In the **New File** dialog that opens, type `text.txt` in the text field. Press **Enter** to create the file.

There are many features of the IDEA. One is called “Context actions”. Place cursor to the wrong word, press **Alt+Enter**, select **Typo: Change to…** with arrows and pressing **Enter**, and finally select the correct word from the list, pressing **Enter** again. The typo disappears :)

## 4. IDEA Settings
The IntelliJ IDEA has a lot of settings that can be configured. Go to **File | Settings**. There are many sections in the open **Settings** tab.
As an example, go to **Appearance & Behavior | Appearance** and choose different themes. We can use a dark theme like Darcula.

## 5. How to start my program?
Just create a new language-specific file, write content, find the green triangle “run” button ( ![]((9)%20IntelliJ%20IDEA/fd073dc5-ef21-4698-9d4a-6be5f748cf5b.png) ), and click it.
Sometimes, the program cannot be started from the IDEA for various reasons.
1.  Make sure the program contains the `main` method. If not, then add it.
2.  The source code should be placed inside the `src` directory, not next to it.
3.  Sometimes JDK is not selected. To fix this, go to **File | Project Structure | Project settings | Project** and then set your JDK in the **Project SDK** section.