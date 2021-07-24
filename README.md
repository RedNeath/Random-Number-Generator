# Random-Number-Generator 1.0
A little app made with Java, using Swing to generate a random number between two bounds defined by the user.<br>
Une petite application en Java, utilisant Swing pour générer un nombre aléatoirement entre deux bornes définies par l'utilisateur.<br>
<br>
This is the first verion of the program.<br>
Ceci est la première version du logiciel.<br>
It isn't meant to work for negative numbers, but will work as long as your values are included between 0 and +∞.<br>
Elle n'est pas faite pour fonctionner avec des nombres négatifs, mais fonctionnera correctement tant que les valeurs entrées sont comprises entre 0 et +∞.<br>
<br>
You can download it in the releases as a jar if you only want to execute it, but your version of Java must be 11.0.9.1 or higher for it to work.<br>
Il est possible de télécharger le logiciel en version exécutable (.jar) dans les releases, mais pour qu'il puisse fonctionner, votre version de Java doit être la 11.0.9.1 ou plus récente.<br>
<br>
<br>
If you want to recompile the code, open a terminal in `ws` and use the following command :<br>
Si vous souhaitez recompiler le code, ouvrez un terminal dans `ws` et entrez la commande suivante :<br>
`javac -d ../class ../src/*.java`<br>
<br>
Now, you might also want to recreate the doc you modified (still in `ws`) :<br>
Une fois cela fait, vous pourriez vouloir recréer la doc que vous avez modifiée (toujours au même endroit) :<br>
`javadoc -private -author -d ../doc ../src/*.java`<br>
<br>
To recreate the jar version, move to `class` in your terminal and use the following command :<br>
Pour recréer la verison jar, déplacez-vous dans `class` dans votre terminal et entrez la commande suivante :<br>
`jar cfm RNG.jar MANIFEST.MF *.class`<br>
<br>
Finally, if you want to add your own language to the program, create a new text file in the `languages` folder, name it `COUNTRY.language` (`SE.language` as an example for Sweden), open the `EN.language` file in the same folder, and translate it line by line in the new file you just created.<br>
Enfin, si vous souhaitez ajouter votre propre langue au programme, créez un nouveau fichier texte dans le dossier `languages`, puis nommez le `PAYS.language` (`SE.language` par exemple pour la Suède), ouvrez le fichier nommé `EN.language` dans le même dossier, et traduisez le ligne par ligne dans le fichier que vous venez de créer.<br>
<br>
Also, if you want your language to be the default language of the program, go into the `languages` folder, find your language, and rename it by adding a 0 at the beginning.<br>
Aussi, si vous souhaitez que votre langue soit définie par défaut, rendez-vous dans le dossier `languages`, trouvez votre langue, et renommez la en ajoutant un 0 au début du nom.
