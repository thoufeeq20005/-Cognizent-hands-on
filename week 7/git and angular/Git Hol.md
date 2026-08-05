# Git HOL

## Configure Identity
```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
```

## Inspect and Stage
```bash
git status
git add <files>
```

## Commit
```bash
git commit -m "Complete Java FSE weeks 1 to 7"
```

## Work with Branches
```bash
git switch -c feature/week-7
```
Then merge through a reviewed pull request.

## Push
```bash
git remote -v
git push -u origin <branch>
```

## Important Rule
Never use `git add .` until `git status` confirms there are no generated or unrelated files.
