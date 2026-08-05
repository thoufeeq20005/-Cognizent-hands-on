import { useState } from 'react';

function Course({ name, complete, onToggle }) {
  return <li><button onClick={onToggle}>{complete ? '✓' : '○'}</button> {name} {complete && <strong> complete</strong>}</li>;
}

export default function App() {
  const [courses, setCourses] = useState([{ name: 'JSX and components', complete: false }, { name: 'Props and state', complete: false }]);
  const toggle = index => setCourses(courses.map((course, i) => i === index ? { ...course, complete: !course.complete } : course));
  return <main><h1>React HOL 1–5</h1><ul>{courses.map((course, index) => <Course key={course.name} {...course} onToggle={() => toggle(index)} />)}</ul></main>;
}
