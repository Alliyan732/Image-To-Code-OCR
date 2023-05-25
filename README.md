
Image to Code OCR Android Application
This Android application allows users to extract text from images using Optical Character Recognition (OCR) technology. It provides a convenient way to convert images containing text into editable and searchable text content.

The application utilizes Google authentication for user login, ensuring a secure and personalized experience for each user. After logging in, users can access the OCR functionality and perform text extraction on images.

Features
Google authentication for secure user login.
Optical Character Recognition (OCR) technology to extract text from images.
Support for various image formats, including JPEG, PNG, and GIF.
User-friendly interface for capturing or selecting images for text extraction.
Ability to edit and refine extracted text.
Copy extracted text to the clipboard for easy sharing or pasting into other applications.
Option to save extracted text as a text file for future reference.
View and manage previously processed images and extracted text.
Installation
Clone the repository to your local machine.
bash
Copy code
git clone https://github.com/your-username/image-to-code.git
Open the project in Android Studio.

Connect your Android device or start an emulator.

Build and run the application on your device/emulator.

Log in using your Google account to access the OCR functionality.

Dependencies
The following dependencies are used in this project:

Google Play Services: for Google authentication.
Firebase Authentication: for user authentication.
Firebase ML Kit: for OCR functionality.
Glide: for image loading and caching.
RecyclerView: for displaying a list of processed images.
Material Components: for UI components and styling.
You can find the specific versions of these dependencies in the build.gradle file.

Usage
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

License
This project is licensed under the MIT License. Feel free to modify, distribute, and use the code for your own purposes.

Acknowledgments
The developers and contributors of the Google Play Services, Firebase, and ML Kit libraries.
The open-source community for providing valuable resources and inspirations.
Support
If you encounter any issues or have any questions or suggestions, please feel free to open an issue. We appreciate your feedback and contributions to the project.

Happy OCR-ing!
