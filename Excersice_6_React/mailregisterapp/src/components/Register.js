import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};

    if (formData.name.trim().length < 5) {
      newErrors.name = 'Name must be at least 5 characters';
    }

    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = 'Email must contain "@" and "."';
    }

    if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });

    // Live validation
    validate();
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert('Form submitted successfully!\n' + JSON.stringify(formData, null, 2));
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    }
  };

  return (
    <div>
      <h2>Register Form</h2>
      <form onSubmit={handleSubmit}>

        <div>
          <label>Name:</label><br />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
          <br />
          {errors.name && <span style={{ color: 'red' }}>{errors.name}</span>}
        </div>
        <br />

        <div>
          <label>Email:</label><br />
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
          />
          <br />
          {errors.email && <span style={{ color: 'red' }}>{errors.email}</span>}
        </div>
        <br />

        <div>
          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <br />
          {errors.password && <span style={{ color: 'red' }}>{errors.password}</span>}
        </div>
        <br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
