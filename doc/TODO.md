# Fighter — TODO

Roadmap of planned work. Newest ideas at the bottom of each section; check items off as they land.

## UI / UX

- [ ] **Tappable page indicator** — make the page indicator respond to taps so it scrolls
  the pager to the tapped page (animated scroll to that index).

## Architecture / Data

- [ ] **Database + preloading + paging** — persist content locally, preload upcoming pages,
  and page data in from the store instead of holding everything in memory.
  - [ ] Choose/set up local persistence (Room).
  - [ ] Wire in Paging 3 (`PagingSource` / `RemoteMediator`).
  - [ ] Preload adjacent pages ahead of the current one.
  - [ ] Reconcile with `MonsterUiState`: Paging 3 has its own `LoadState`
    (refresh/append/prepend). Expect to keep a top-level "initial refresh"
    Loading/Error, but move page-append loading/errors into the Paging APIs —
    reshape `MonsterUiState`, don't just delete it. (Currently `MockMonsterApi`
    never fails, so Loading/Error are unexercised until a real source lands.)

## Compose

- [ ] **Advanced pager usage** — explore richer `HorizontalPager`/`VerticalPager` features
  (custom page sizing, snapping, `beyondViewportPageCount`/offscreen limit, per-page
  transforms driven by `PagerState`).

---
_Last updated: 2026-07-04_
