import { useEffect, useMemo, useState } from 'react';

const initialProducts = [{ id: 1, name: 'Keyboard', price: 1800 }, { id: 2, name: 'Mouse', price: 700 }];

export default function App() {
  const [products, setProducts] = useState([]);
  const [query, setQuery] = useState('');
  const [name, setName] = useState('');

  useEffect(() => { setProducts(initialProducts); }, []);

  const visible = useMemo(() => products.filter(p => p.name.toLowerCase().includes(query.toLowerCase())), [products, query]);

  function add(event) {
    event.preventDefault();
    if (name.trim()) {
      setProducts([...products, { id: Date.now(), name: name.trim(), price: 0 }]);
      setName('');
    }
  }

  return (
    <main>
      <h1>React HOL 6–8: Product catalogue</h1>
      <input aria-label="Filter products" value={query} onChange={e => setQuery(e.target.value)} placeholder="Filter" />
      <ul>{visible.map(p => <li key={p.id}>{p.name} — ₹{p.price}</li>)}</ul>
      <form onSubmit={add}>
        <input value={name} onChange={e => setName(e.target.value)} placeholder="New product" />
        <button>Add</button>
      </form>
    </main>
  );
}
