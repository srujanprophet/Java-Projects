# Parameters and options
## 1. Commands with parameters
* Sometimes using just one command is not enough. 
* The command `mkdir`, is used to create a new folder in the current directory. If we try to use it as it is, we will get an error. The terminal needs to know how to name a new folder!. That’s when parameters come in handy.
* A **parameter** is some additional information that we give to the command. Simply put, parameters are variables that commands can take.
`C:\users\student> mkdir papers`
* We can use `cd` command to change current directory. 
`C:\users\student> cd C:\users\student\papers`
`C:\users\student\papers>`
* Another useful parameter of the `cd` command is `..`. It allows us to go to the **parent directory**, the directory one level above the current one.
`C:\users\student\papers> cd ..`
`C:\users\student>`
* We can also go back to the **root folder**, a top-level directory in the file system using the `/` parameter:
`C:\users\student> cd /`
`C:\`

## 2. Options
* **Options** are usually optional and are used to somehow change the common behaviour of the command.
* For example, the `/d` option to the `cd` in Windows :
`C:\users\student\Desktop cd /d F:\Codepen snippets`
`F:\Codepen snippets>`
* To sum up: what are essentially options and parameters? Both of them are just two particular types of arguments. While an **option** changes the behaviour of a command, a **parameter** is used to assign information to either a command or one of its options.
* One of the key differences between them is that the number of possible values in options is limited and locked in the code, while with parameters users have more freedom as they don’t have such limitations.

## 3. Help Manual
* No one can remember all the existing commands, options, and parameters.    For that, the `help` command is there, type it in Windows, and we will get a list of commands available to us.
* For Linux and macOS, a way to get information about the commands depends on the shell we use. The most often command to get help is `man` , short for *manual*. We can use it similar to the help command in Windows: `man mkdir`.
* The `help` command can take any command as a parameter and return all the available options. For `cd`:
```
C:\users\student> help cd
Displays the name of or changes the current directory.
CD [/D] [drive:][path]
CD [..]
   ..  Specifies that you want to change to the parent directory.
Type CD drive: to display the current directory in the specified drive.
Type CD without parameters to display the current drive and directory.
Use the /D switch to change the current drive in addition to changing the current directory for a drive.
<...> 
```
These are all the commands we need to know about the `cd` command. We call this description the **help manual**.
* First, the help manual states what the command is supposed to do. For `cd` command, it reads *“Displays the name of or changes the current directory”*. Then it returns all the combinations of that command along with all possible parameters that we can use.
* In Windows, commands are case insensitive unlike in Linux and macOS. For example, a command from the manual :
`CD [/D] [drive:][path]`
So, the above command has three parts. `CD` is the command name. `[/D]` is an option, and `[drive:][path` is a parameter.
The `[]` brackets are just *notations* that mean that the parameters are optional to the commands. Some people and some systems use `<>`for that.

## 4. Conclusion
* We can use options and parameters to extend the functionality of commands.
* We can pass different values with the parameters.
* We can get a full list of commands using the `help` and `man` commands.
* We can open a help manual for a command by typing `help [command_name` or `man [command_name]`. This manual explains how to use a command properly and what options and parameters it has, if any.

