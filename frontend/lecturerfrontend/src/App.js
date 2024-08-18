import React, { useState } from 'react';
import SearchAppBar from './components/Appbar';
import LecturerForm from './components/Lecturer';

function App() {
  const [searchTerm, setSearchTerm] = useState('');

  const handleSearch = (term) => {
    setSearchTerm(term);
  };

  return (
    <div className="App">
      <SearchAppBar onSearch={handleSearch} />
      <LecturerForm searchTerm={searchTerm} />
    </div>
  );
}

export default App;
