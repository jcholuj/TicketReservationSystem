import React, { Suspense, lazy } from 'react';
import { Route, Switch } from 'react-router-dom';
import Loader from './pages/Loader';

const AccountPage = lazy(() => import('./pages/Account/AccountPage'));
const SearchPage = lazy(() => import('./pages/Search/SearchPage'));
const TimetablePage = lazy(() => import('./pages/Timetable/TimetablePage'));

export default function App() {
	return (
		<Suspense fallback={<Loader />}>
			<Switch>
				<Route exact path='/'>
					<SearchPage />
				</Route>
				<Route path='/account'>
					<AccountPage />
				</Route>
				<Route path='/timetable'>
					<TimetablePage />
				</Route>
			</Switch>
		</Suspense>
	);
}
