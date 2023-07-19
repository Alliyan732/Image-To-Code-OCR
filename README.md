## Image to Code OCR Android Application
This Android application allows users to extract text from images using Optical Character Recognition (OCR) technology. It provides a convenient way to convert images containing text into editable and searchable text content.

The application utilizes Google authentication for user login, ensuring a secure and personalized experience for each user. After logging in, users can access the OCR functionality and perform text extraction on images.

## ScreenShots

![1](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/4f20a2c9-4167-4782-b9c8-40529afe9b72)
![2](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/beaa0438-40c4-49aa-8424-1d5c2db51561)
![3](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/e95c1c8a-0297-44d6-a502-31533f26a9fe)
![4](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/58e817ba-affb-43c3-8ece-b5f305f6a984)
![5](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/e38a34bc-af0c-4fcb-90e1-6c0db088ea9c)
![6](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/dd3cae96-00e3-4336-97ef-79be994f4c8f)
![7](https://github.com/Alliyan732/Image-To-Code-OCR/assets/95461559/392d9271-0f4e-4b46-a334-e56fc98cfb73)

## Features
Google authentication for secure user login.
Optical Character Recognition (OCR) technology to extract text from images.
Support for various image formats, including JPEG, PNG, and GIF.
User-friendly interface for capturing or selecting images for text extraction.
Ability to edit and refine extracted text.
Copy extracted text to the clipboard for easy sharing or pasting into other applications.
Option to save extracted text as a text file for future reference.
View and manage previously processed images and extracted text.

## Installation
Clone the repository to your local machine.
git clone https://github.com/your-username/image-to-code.git
Open the project in Android Studio.

Connect your Android device or start an emulator.

Build and run the application on your device/emulator.

Log in using your Google account to access the OCR functionality.

## Dependencies
The following dependencies are used in this project:
Google Play Services: for Google authentication.
Firebase Authentication: for user authentication.
Firebase ML Kit: for OCR functionality.
Glide: for image loading and caching.
RecyclerView: for displaying a list of processed images.
Material Components: for UI components and styling.
You can find the specific versions of these dependencies in the build.gradle file.

## Usage
Launch the application on your Android device.
Log in using your Google account credentials.
Once logged in, you will be redirected to the main screen.
To perform OCR on an image:
Capture a new image using the camera icon or
Select an existing image from your device's gallery using the gallery icon.
The image will be processed, and the extracted text will be displayed on the screen.
Edit or refine the extracted text if needed.
Copy the text to the clipboard or save it as a text file using the respective options.
You can view your processed images and extracted text in the history section.
Logout from your Google account when you're finished using the application.

## steps for generating the SHA-1 key and configuring Google Login in the API console:

Open your Android Studio project.
Click on the Gradle tab on the right side of the screen.
Expand the project structure until you see your app module.
Expand the app module and double-click on the signingReport task under the android folder.
After executing the task, locate the SHA-1 key in the "Run" tab at the bottom of the screen. It should be listed as "SHA1: XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX:XX".
Copy the SHA-1 key as you will need it for the next steps.
Open the Google Cloud Console.
Create a new project or select an existing project.
In the sidebar, click on "Credentials".
Click on the "Create credentials" button and select "OAuth client ID".
Select "Android" as the application type.
In the "Package name" field, enter the package name of your Android application (e.g., com.example.image2code).
In the "SHA-1 certificate fingerprint" field, paste the copied SHA-1 key.
Click on the "Create" button to generate the OAuth client ID.
Once the client ID is created, you will see the "OAuth client ID" page with your client ID and client secret.
Copy the generated client ID as you will need it to configure Google Login in your Android application.
In your Android Studio project, open the google-services.json file located in the app module.
Replace the existing client_id value with your generated client ID from the API console.
Save the google-services.json file.
Sync your project with the Gradle files by clicking on the "Sync Now" button that appears in the toolbar.

## License
This project is licensed under the MIT License. Feel free to modify, distribute, and use the code for your own purposes.

## Acknowledgments
The developers and contributors of the Google Play Services, Firebase, and ML Kit libraries.
The open-source community for providing valuable resources and inspirations.

## Support
If you encounter any issues or have any questions or suggestions, please feel free to open an issue. We appreciate your feedback and contributions to the project.

- Email: alliyan732@gmail.com
- LinkedIn: https://www.linkedin.com/in/alliyan-alvi/

Happy OCR-ing!
