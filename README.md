# Outfit Generator & Virtual Dress-Up System (JavaFX)

## How to Run
1. Open the project in VS Code or your preferred Java IDE.
2. Ensure Java JDK 21+ and JavaFX SDK are installed.
3. Compile the project:

```bash
javac --module-path /PATH_TO_JAVAFX/lib --add-modules javafx.controls src/Main.java src/views/*.java src/models/*.java src/services/*.java
<<<<<<< HEAD
=======
```
>>>>>>> 63d81df38a1495980f2fa85a45338e93820ab85b

# Features
- Upload clothing images into the application.
- Categorize clothing items:
- Tops
- Bottoms
- Shoes
- Preview uploaded clothing images.
- Display a digital wardrobe with uploaded items.
- Create outfits visually using clothing images.
- Switch between tops, bottoms, and shoes.
- Randomize outfit combinations.
- Save custom-named outfits.
- View saved outfits with clothing images.
- Delete saved outfits.
<<<<<<< HEAD
- Persistent local storage using image folders and text files.
=======
- Persistent local storage using image folders and text files.

## Notes
- Clothing images are stored inside:
  - `assets/tops`
  - `assets/bottoms`
  - `assets/shoes`

- Saved outfits are stored in:
  - `data/savedOutfits.txt`

- Uploaded clothing updates the wardrobe and outfit builder automatically.

- Supported image formats:
  - `.png`
  - `.jpg`
  - `.jpeg`
>>>>>>> 63d81df38a1495980f2fa85a45338e93820ab85b
