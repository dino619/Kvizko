# Kvizko

Kvizko is an Android quiz application designed to help users learn through interactive quizzes. The app allows users to sign up, log in, choose categories, take quizzes, and track their progress over time.

## 📱 Screenshots

### **App Setup**
| App Launch | Sign Up | Login |
|------------|--------|-------|
| ![App Launch](https://github.com/user-attachments/assets/154fbf03-d139-4c35-a926-609d61ebe0be) | ![Sign Up](https://github.com/user-attachments/assets/29931f0e-baf1-4422-9fb1-264af171f32c) | ![Login](https://github.com/user-attachments/assets/186d0797-4a8e-4b81-83ab-011c9062d96a) |
| **Description:** When the user launches Kvizko, the app logo and name appear before redirecting to the login or sign-up screen. | **Description:** Users must enter their name, email, password, and confirmation password to create an account. | **Description:** Existing users can log in using email and password or Google authentication. |

### **Navigation**
| Home Screen | Side Navigation |
|------------|--------------|
| ![Home Screen](https://github.com/user-attachments/assets/54fe373a-9aa5-4dae-bafd-a393adfdf9c3) | ![Side Navigation](https://github.com/user-attachments/assets/024c4db8-2a6e-4f47-9c36-f0393dc24348) |
| **Description:** The main screen displays quiz categories, each showing the number of available tests. Users navigate using the bottom navigation bar. | **Description:** The side navigation bar allows users to switch between sections such as profile, leaderboard, and saved questions. |

### **Quiz Selection**
| Category List | Quiz Selection |
|--------------|--------------|
| ![Category List](![418285617-1cf1b75a-8206-4233-bc39-a7203391d8e2](https://github.com/user-attachments/assets/53bcd343-a333-4055-b5bf-490c5d4d2388)
) | ![Quiz Selection](![418285630-65ba318f-b97d-40fd-93f3-db94159ccb06](https://github.com/user-attachments/assets/91f95269-7aff-422e-a799-d3b86d5ed3f4)
) |
| **Description:** When selecting a category, users see all available tests along with a progress bar showing their best score. | **Description:** Users can view test details, including category, total questions, best score, time limit, and a start button. |

### **Taking a Quiz**
| Quiz Questions | Answer Grid |
|---------------|-------------|
| ![Quiz Questions](![418285620-4760ac83-891a-4a25-aed3-ceb7466397bc](https://github.com/user-attachments/assets/3c519886-e3f0-4e94-aac3-7dec5bb5f69a)
) | ![Answer Grid](![418285621-83fcdac6-d937-4e1b-859d-7686d33b7f6a](https://github.com/user-attachments/assets/30ba6a67-ab80-4c87-8546-297b62702b75)
) |
| **Description:** The quiz interface features multiple-choice questions, allowing users to navigate using buttons or swipe gestures. Additional options include clearing a selected answer and marking a question for review. | **Description:** The answer grid displays different statuses: **Answered**, **Unanswered**, **Not Visited**, and **Review** (for marked questions). |

### **Results & Performance Tracking**
| Quiz Result | Answer Review |
|------------|--------------|
| ![Quiz Result](![418285624-a01425d2-4911-4ac3-ab53-530aa8e24e99](https://github.com/user-attachments/assets/866592a5-6faa-4015-baf0-18772c3f34c3)
) | ![Answer Review](![418285618-80ca7893-0b93-484c-82e0-716e366bd808](https://github.com/user-attachments/assets/0c893d37-fc08-4a06-9e30-014f495fbfb0)
) |
| **Description:** After completing a quiz, users receive a percentage score, total time taken, and the count of correct, incorrect, and unanswered questions. | **Description:** Users can review their answers to see which questions were correct, incorrect, or left blank. |

### **Leaderboard & Profile**
| Leaderboard | My Account | Saved Questions |
|------------|-----------|----------------|
| ![Leaderboard](![418285622-99694d09-7bfd-4449-9f19-68b2f0217249](https://github.com/user-attachments/assets/34cd57fc-faa8-42d2-bd0d-c232f1d84ecd)
) | ![My Account](![418285619-a007b2d5-925d-44b1-ab6a-10f71e949901](https://github.com/user-attachments/assets/27a821fe-1e79-4790-be5d-82580961013c)
) | ![Saved Questions](![418285623-3e31898b-255a-4a70-a85a-84998c1f14ed](https://github.com/user-attachments/assets/a33669b5-72e8-470a-b831-ee2560c5488e)
) |
| **Description:** The leaderboard ranks users based on their quiz scores and shows their current standing. | **Description:** The "My Account" section displays user details, ranking, and access to profile settings and logout. | **Description:** Users can save specific questions for later review. |

---

## 🚀 Features

### 🔹 User Authentication
- Users can **sign up** with their email and password.
- Login options include **email/password authentication** and **Google sign-in**.

### 🔹 Home Screen
- Displays quiz categories with the number of tests available in each category.
- Navigation through **bottom navigation bar** and **side navigation drawer**.

### 🔹 Quiz System
- Each category contains multiple quizzes.
- Users can track their **best score** for each test.
- Quiz interface includes:
  - **Multiple-choice questions** with easy navigation.
  - **Progress tracking** to show completed and remaining questions.
  - **Timer** to complete quizzes within a set duration.

### 🔹 Answer Review & Results
- After submitting a quiz, users can see:
  - **Score percentage**
  - **Total correct, incorrect, and unanswered questions**
- Option to **retry the quiz** or **review answers**.

### 🔹 Leaderboard
- Users can view the **global leaderboard** to compare scores.
- Displays the **top players** and the **user's current ranking**.

### 🔹 Profile & Account Management
- Displays **username, rank, and total score**.
- Access to:
  - **Saved questions**
  - **Leaderboard**
  - **Profile settings**
  - **Logout option**

---

## 🔧 Technologies Used
- **Android Studio**: Main development environment.
- **Firebase**: Used for authentication, real-time database, and backend services.

## 🚀 How to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/dino619/Kvizko.git
