import React, { useState } from "react";

// Sample data for each component
const books = [
  { id: 1, title: "React Basics", author: "John Doe" },
  { id: 2, title: "Advanced React", author: "Jane Smith" },
];

const blogs = [
  { id: 1, title: "React Hooks", date: "2025-08-01" },
  { id: 2, title: "React Router Tips", date: "2025-08-03" },
];

const courses = [
  { id: 1, name: "React for Beginners", duration: "3 weeks" },
  { id: 2, name: "Fullstack with React", duration: "6 weeks" },
];

// 1. BookDetails Component
function BookDetails({ books }) {
  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map((book) => (
          // Use key prop for list items
          <li key={book.id}>
            <strong>{book.title}</strong> by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

// 2. BlogDetails Component
function BlogDetails({ blogs }) {
  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        {blogs.map(({ id, title, date }) => (
          <li key={id}>
            <strong>{title}</strong> - <em>{date}</em>
          </li>
        ))}
      </ul>
    </div>
  );
}

// 3. CourseDetails Component
function CourseDetails({ courses }) {
  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <strong>{course.name}</strong> ({course.duration})
          </li>
        ))}
      </ul>
    </div>
  );
}

function App() {
  // Use state to track which component to show
  const [show, setShow] = useState("books"); // default to books

  // Multiple ways of conditional rendering:

  // 1. Using if-else with element variable
  let content;
  if (show === "books") {
    content = <BookDetails books={books} />;
  } else if (show === "blogs") {
    content = <BlogDetails blogs={blogs} />;
  } else if (show === "courses") {
    content = <CourseDetails courses={courses} />;
  } else {
    content = <p>Please select an option above.</p>;
  }

  return (
    <div style={{ textAlign: "center", fontFamily: "Arial", marginTop: "40px" }}>
      <h1>Blogger App</h1>

      {/* Buttons to toggle views */}
      <button onClick={() => setShow("books")} style={{ margin: "0 5px" }}>
        Books
      </button>
      <button onClick={() => setShow("blogs")} style={{ margin: "0 5px" }}>
        Blogs
      </button>
      <button onClick={() => setShow("courses")} style={{ margin: "0 5px" }}>
        Courses
      </button>

      <hr style={{ margin: "20px auto", width: "50%" }} />

      {/* 2. Render component via element variable */}
      {content}

      {/* 3. Inline conditional rendering using && operator */}
      <div style={{ marginTop: "40px" }}>
        <h3>Inline conditional rendering example:</h3>
        {show === "books" && <p>You are viewing Book Details.</p>}
        {show === "blogs" && <p>You are viewing Blog Details.</p>}
        {show === "courses" && <p>You are viewing Course Details.</p>}
      </div>

      {/* 4. Ternary operator example */}
      <div style={{ marginTop: "20px" }}>
        {show === "books" ? (
          <p>Ternary: Book list is shown</p>
        ) : (
          <p>Ternary: Not viewing books</p>
        )}
      </div>
    </div>
  );
}

export default App;
